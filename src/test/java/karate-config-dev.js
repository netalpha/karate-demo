function fn_dev() {
    var port = karate.properties['demo.server.port'];
    if (!port) {
        port = karate.env == 'web' ? 8090 : 8080;
    }

    var config = { baseUrl: 'http://localhost:' + port };

    return config;
}