# HW10 Readme

HW10 is designed with the MVC design pattern.

## Model and View

The HW10 only requires one part to display the view, which is when the user's request is confirmed.
The system will display a view of the current seat mapping of the theater. Since this view is so
trivial, I just incorporate this show view as a method in the theater class. Therefore, there is no
separate class designated to display the view. The theater, row, seats, Operation are all model. All
of these four classes define how they are structured. For example, row is composed of seats, theater
is composed of rows. Operation is just an enum class defining what possible user input the system
can take in.

## Controller

The reservation service and system are the controller of this command line reservation service. Once
the user input the command, for example, reserve, show, and done, the system will respond by
processing the user's request and update the theater's occupancy. Once the update is finished, if
the user's request is confirmed, a new seating map will be displayed.

## Observer pattern

The reservation service is basically using a observer pattern. When the command line program is
running, the system will listen for the response from the user. If the user input something wrong,
it will hint the user of the correct behavior. If the user input something correct, it will update
the model accordingly and display the correct data into the console.

