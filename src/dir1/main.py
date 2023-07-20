def function_handler(request):
    request_json = request.get_json(silent=True)
    #link = request_json['link'] # https://github.com/jdorfman/awesome-json-datasets
    link ="https://www.vizgr.org/historical-events/search.php?format=json&begin_date=-3000000&end_date=20151231&lang=en"
    req = urllib.request.Request(
    link, 
    data=None, 
    headers={
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.47 Safari/537.36'
    }
    )
    start = time()
    f = urlopen(req)
    data = f.read().decode("utf-8")
    network1 = time() - start
    start = time()
    json_data = json.loads(data)
    str_json = json.dumps(json_data, indent=4)
    latency1 = time() - start

    print("network : " + str(network1) \
        + "/ latency : " + str(latency1))
    return("network : " + str(network1) \
        + "/ latency : " + str(latency1))