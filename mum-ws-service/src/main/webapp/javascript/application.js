angular.module('angular.atmosphere.chat', ['angular.atmosphere']);

function ChatController($scope, atmosphereService) {
    $scope.model = {
        transport: 'websocket',
        messages: []
    };

    var socket;

    var request = {
        url: '/mum/push',
        contentType: 'application/json',
        logLevel: 'debug',
        transport: 'websocket',
        trackMessageLength: true,
        reconnectInterval: 5000,
        enableXDR: true,
        timeout: 60000
    };

    request.onOpen = function (response) {
        $scope.model.transport = response.transport;
        $scope.model.connected = true;
        $scope.model.content = 'Atmosphere connected using ' + response.transport;
    };

    request.onReopen = function (response) {
        $scope.model.connected = true;
        $scope.model.content = 'Atmosphere re-connected using ' + response.transport;
    };


    request.onError = function (response) {
        $scope.model.content = "Sorry, but there's some problem with your socket or the server is down";
        $scope.model.logged = false;
    };

    request.onReconnect = function (request, response) {
        $scope.model.content = 'Connection lost. Trying to reconnect ' + request.reconnectInterval;
        $scope.model.connected = false;
    };

    socket = atmosphereService.subscribe(request);
}