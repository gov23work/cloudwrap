resource "google_storage_bucket" "function_bucket" {
    name     = "${var.project_id}-function"
    location = var.region
}

resource "google_storage_bucket" "input_bucket" {
    name     = "${var.project_id}-input"
    location = var.region
}

data "archive_file" "source1" {
    type        = "zip"
    source_dir  = "../src/dir1"
    output_path = "./tmp/function1.zip"
}

data "archive_file" "source2" {
    type        = "zip"
    source_dir  = "../src/dir2"
    output_path = "./tmp/function2.zip"
}

data "archive_file" "sourcewrapper" {
    type        = "zip"
    source_dir  = "../src/wrapper"
    output_path = "./tmp/wrapper.zip"
}

# Add source code zip to the Cloud Function's bucket
resource "google_storage_bucket_object" "zip1" {
    source       = data.archive_file.source1.output_path
    content_type = "application/zip"

    # Append to the MD5 checksum of the files's content
    # to force the zip to be updated as soon as a change occurs
    name         = "src-${data.archive_file.source1.output_md5}.zip"
    bucket       = google_storage_bucket.function_bucket.name
}
resource "google_storage_bucket_object" "zip2" {
    source       = data.archive_file.source2.output_path
    content_type = "application/zip"

    # Append to the MD5 checksum of the files's content
    # to force the zip to be updated as soon as a change occurs
    name         = "src-${data.archive_file.source2.output_md5}.zip"
    bucket       = google_storage_bucket.function_bucket.name
}
resource "google_storage_bucket_object" "wrapper" {
    source       = data.archive_file.sourcewrapper.output_path
    content_type = "application/zip"

    # Append to the MD5 checksum of the files's content
    # to force the zip to be updated as soon as a change occurs
    name         = "src-${data.archive_file.sourcewrapper.output_md5}.zip"
    bucket       = google_storage_bucket.function_bucket.name
}

