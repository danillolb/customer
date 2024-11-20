# Customer API

## Overview

The Customer API is a Spring Boot application designed to manage customer information. It provides a RESTful interface for retrieving customer details based on their unique identifier.

## Technologies Used

- Java
- Spring Boot
- Gradle

## API Endpoints

### Get Customer by ID

- **URL**: `/api/customer/{id}`
- **Method**: `GET`
- **Path Variable**: `id` (Long) - The unique identifier of the customer.
- **Response**: `CustomerDTO` - The customer details.

## Data Model

### CustomerDTO

- `id` (Long): The unique identifier of the customer.
- `name` (String): The name of the customer.
- `vip` (Boolean): Indicates if the customer is a VIP.

## Usage

To retrieve a customer by their ID, send a `GET` request to `/api/customer/{id}`. The response will be a `CustomerDTO` object containing the customer's details.

## Server Port
```8082```