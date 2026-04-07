📘 README – Use Case 6: Reservation Confirmation & Room Allocation
📌 Description

This use case implements the final booking confirmation system, where requests from the queue are processed and rooms are allocated safely.

It ensures:

No double booking
Unique room assignment
Consistent inventory updates
🎯 Goal
Confirm booking requests from queue
Assign unique room IDs
Prevent duplicate room allocation
Keep inventory synchronized
👤 Actors
BookingService – processes requests and allocates rooms
RoomInventory – manages availability
🔄 Flow of Execution
Booking request is taken from queue (FIFO)
System checks room availability
Unique room ID is generated
Room ID stored in a Set (no duplicates)
Inventory is reduced immediately
Booking is confirmed or rejected
🧠 Key Concepts Used
Queue (FIFO)
Processes requests in order
Set
Ensures unique room IDs
HashMap
Maps room type → allocated rooms
Double Booking Prevention
No room ID reused
Atomic Operation
Allocation + inventory update together
🛠️ Technologies Used
Core Java
OOP Concepts
Queue, HashMap, HashSet