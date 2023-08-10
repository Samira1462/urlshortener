# URL Shortener

## Table of Contents

- [Introduction](#introduction)
- [Assumptions](#assumptions)
- [Tech Test](#tech-test)
    - [Deliverables](#deliverables)
    - [Setup](#setup)
    - [App Requirements](#app-requirements)
    - [Running the App](#running-the-app)
- [API Endpoints](#api-endpoints)
    - [Create Shortened URL](#create-shortened-url)
    - [Redirect to Original URL](#redirect-to-original-url)

## Introduction

Welcome to the URL Shortener project! This application allows users to create shortened versions of long URLs, making them easier to share and manage. This README provides information about the project, its assumptions, setup instructions, and API endpoints.

## Assumptions

When approaching this challenge, the following assumptions have been made:

1. Shortened URL Length: The shortened URL will be kept as short as possible to enhance usability.
2. Scaling: The system is designed to function as a single instance, considering this is a code challenge.
3. Database: The choice of database (NoSQL or relational) depends on the amount of data that needs to be persisted.
4. Hashing Algorithm: An appropriate hashing algorithm will be chosen based on a balance between security and efficiency.

## Tech Test

### Deliverables

Setup the environment and develop an application that meets the following requirements:

### Setup

Make sure you have the following tools installed on your local machine:

- Java Virtual Machine (JVM) 11
- Apache Maven
- An Integrated Development Environment (IDE) of your choice

### App Requirements

The application should expose HTTP endpoints to manage URL entities.

### Running the App

To run the application, follow these steps:

1. Open a terminal window.
2. Navigate to the project directory.
3. Run the following Maven command:

   ```sh
   ./mvnw spring-boot:run


# API Endpoints
The following API endpoints are provided by the application:

## Create Shortened URL
POST http://localhost:8080/generate
{
"url": "https://www.baeldung.com/kotlin/concatenate-strings"
}

## Redirect to Original URL
GET http://localhost:8080/{shorturl}

Redirect to the original URL using the shortened URL code.

