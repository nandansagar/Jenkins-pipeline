// vars/createMessage.groovy
def call(String status) {
    def themeColor
    def style
    switch (status) {
        case "Build Started":
            themeColor = '#007BFF'  // Blue
            style = 'good'
            break
        case "Build Successful":
            themeColor = '#006400'  // DarkGreen
            style = 'good'
            break
        case "Build Failure":
            themeColor = '#8B0000'  // DarkRed
            style = 'attention'
            break
    }

    def commitMessage = "No commit message" // Default if COMMIT_MSG is not available
    if (env.COMMIT_MSG) {
        commitMessage = env.COMMIT_MSG
    }

    def buildNumber = env.BUILD_NUMBER
    def projectURL = env.BUILD_URL
    def projectName = env.JOB_NAME
    def workingDirectory = env.WORKSPACE
    def commitId = env.GIT_COMMIT
    def buildUser = env.BUILD_USER_ID ?: "Nandan A"  // Jenkins plugin may provide this value

    def message = [
        "email_id": "nandan.a@signdesk.com",  // Your email ID
        "room_id": "f563e6c1-bf82-49f9-9feb-d3d643fd097b",  // Room ID to send the notification
        "string": """
            Jenkins Build ${projectName} - ${env.BUILD_DISPLAY_NAME}
            Status: **${status}**
            Build Number: ${buildNumber}
            Project URL: ${projectURL}
            Project Name: ${projectName}
            Working Directory: ${workingDirectory}
            Commit ID: ${commitId}
            Build User: ${buildUser}
            Pipeline Duration: ${currentBuild.durationString}
            Commit Message: **${commitMessage}**
        """,
        "ref_id": "${env.BUILD_URL}"  // Reference to the build URL for details
    ]
    
    return message
}
