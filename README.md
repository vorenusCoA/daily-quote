# daily-quote
A Spring Web App that shows a new quote every day

## Description
- The Daily Quote App uses quotes provided by [zenquotes.io](https://zenquotes.io/).
- The server makes 1 call per day to the Zenquote API to retrieve their daily quote (the result is then cached).
- Every day at midnight (00:00 CST) the server will clear the cached quote.
- You can see it working here: https://daily-quote.azurewebsites.net/ (have in mind that it's hosted on the Azure free tier so it could take some time to wake up :sleeping:)

## Local development

### Prerequisites

- [Gradle](https://gradle.org/)
- [Java 17](https://www.azul.com/downloads/?package=jdk)

### Steps

- Clone the repository
- Execute `./gradlew bootRun`
- Access to `localhost:8080`
