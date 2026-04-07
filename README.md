📌 Description

This use case adds optional services (like breakfast, pickup, extra bed) to an existing reservation.

It enhances the booking system without modifying:

Room allocation
Inventory logic
🎯 Goal
Attach multiple services to a reservation
Maintain flexibility and extensibility
Calculate additional service cost
👤 Actors
Guest – selects add-on services
AddOnService – represents a service
AddOnServiceManager – manages services
🔄 Flow of Execution
Reservation already exists
Guest selects add-on services
Services are stored in a list
List is mapped to reservation ID
Services are displayed
Total cost is calculated
🧠 Key Concepts Used
Map + List
Reservation → multiple services
One-to-Many Relationship
One booking → many services
Composition
Services attached to reservation
Separation of Concerns
Add-ons ≠ booking logic
Cost Aggregation
Total service cost calculated separately
🛠️ Technologies Used
Core Java
OOP Concepts
HashMap & ArrayList