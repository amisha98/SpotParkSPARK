# SpotParkSPARK

This project is aimed to help people locate empty parking spots around a particular destination.  

The project consists of some basic activities showing the parking spots in the form of checkboxes. The parking which ar empty are 
unchecked whereas those which are empty are unchecked.

There are four types of parking:
1. Student Parking (18)
2. Faculty Parking (10)
3. Common Parking (5)
4. Parking for 2 wheeler (20)

Seperate acitivities for each of these types of parkings are present with a common layout but seperate backend.

The data about all parking spots are fetched from Firebase Realtime Database. 
Data stored about the parking spots: 
1. Parking Spot Number (S1.../P1.../TW1.../F1...)
2. Availability (0/1)

**The repository also contains the apk file(app-debug.apk) for the application for testing purposes.

Future Scope:
1. Adding latitude and longitude of each parking spot and calculating the distance between the user and the nearest parking spot.
