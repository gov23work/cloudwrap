resource "google_cloudfunctions_function" "function" {
    name                  = "function1"
    runtime               = "python37"  # of course changeable

    # Get the source code of the cloud function as a Zip compression
    source_archive_bucket = google_storage_bucket.function_bucket.name
    source_archive_object = google_storage_bucket_object.zip1.name

    # Must match the function name in the cloud function `main.py` source code
    entry_point           = "function_handler"
    
    # 
    trigger_http          = true


}
resource "google_cloudfunctions_function" "function2" {
    name                  = "function2"
    runtime               = "python37"  # of course changeable

    # Get the source code of the cloud function as a Zip compression
    source_archive_bucket = google_storage_bucket.function_bucket.name
    source_archive_object = google_storage_bucket_object.zip2.name

    # Must match the function name in the cloud function `main.py` source code
    entry_point           = "function_handler"
    
    # 
    trigger_http          = true

}
resource "google_cloudfunctions_function" "wrapper" {
    name                  = "wrapper"
    runtime               = "python37"  # of course changeable

    # Get the source code of the cloud function as a Zip compression
    source_archive_bucket = google_storage_bucket.function_bucket.name
    source_archive_object = google_storage_bucket_object.wrapper.name

    # Must match the function name in the cloud function `main.py` source code
    entry_point           = "function_handler"
    
    # 
    trigger_http          = true

}