// vars/start.groovy
def call() {
    def message = createMessage("Build Started")
    sendNotificationToMalento(message)
}
// vars/Success.groovy
def call() {
    def message = createMessage("Build Successful")
    sendNotificationToMalento(message)
}
// vars/Failure.groovy
def call() {
    def message = createMessage("Build Failure")
    sendNotificationToMalento(message)
}
