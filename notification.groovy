// vars/sendNotificationToMalento.groovy
def call(Map message) {
    def response = httpRequest(
        httpMode: 'POST',
        acceptType: 'APPLICATION_JSON',
        contentType: 'APPLICATION_JSON',
        customHeaders: [
            [name: 'Client-ID', value: 'QHTRkR4RbXDpVYJaeVscAJX1iVWFTLpv'],
            [name: 'Client-Secret', value: 'u9D3xDvoabq76nlls3Nbl9PJszdNhHoU']
        ],
        url: "https://api.melento.com/api/z/chat/message/createForChannel",
        requestBody: groovy.json.JsonOutput.toJson(message)
    )
}
