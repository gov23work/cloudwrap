def function_handler(request):
    request_json = request.get_json(silent=True)
    #link = request_json['link'] # https://github.com/jdorfman/awesome-json-datasets
    link ="https://www.vizgr.org/historical-events/search.php?format=json&begin_date=-3000000&end_date=20151231&lang=en"
    req2 = urllib.request.Request(
    link, 
    data=None, 
    headers={
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1916.47 Safari/537.36'
    }
    )
    req3 = urllib.request.Request(
    link, 
    data=None, 
    headers={
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1916.47 Safari/537.36'
    }
    )
    start = time()
    f = urlopen(req2)
    k = urlopen(req3)
    data = f.read().decode("utf-8") 
    data2 = k.read().decode("utf-8")
    network2 = time() - start

    start = time()
    json_data = json.loads(data)
    str_json = json.dumps(json_data, indent=4)
    json_data = json.loads(data2)
    str_json = json.dumps(json_data, indent=4)
    latency2 = time() - start

    print("network : " + str(network2) \
        + "/ latency : " + str(latency2))
    return("network : " + str(network2) \
        + "/ latency : " + str(latency2))