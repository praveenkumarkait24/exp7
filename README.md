# Experiment 7: Implementing UI Elements

## Aim
To design and develop an Android application that demonstrates the use of common UI elements — a TextField for input, a Label to display text, a Toolbar for the app bar, a Status Bar to show application state, and a Tab Bar to switch between multiple sections of the screen.

## Objectives
- To implement an application Toolbar using Jetpack Compose's TopAppBar.
- To implement a Tab Bar with multiple tabs using TabRow and Tab.
- To accept user input using a TextField (OutlinedTextField).
- To display read-only information using a Label (Text composable).
- To implement a Status Bar at the bottom of the screen using BottomAppBar that reflects the current state of the app.
- To combine Toolbar, Tab Bar, content area and Status Bar together using Scaffold.
- To update the Label and Status Bar dynamically based on the TextField input and the selected tab.

## Procedure / Algorithm
1. Create a new Android project using Kotlin and Jetpack Compose.
2. Design MainActivity.kt using a Scaffold, which provides dedicated slots for a top bar, a bottom bar and the main content.
3. Implement the Toolbar by passing a TopAppBar with a title to the topBar slot of the Scaffold.
4. Implement the Status Bar by passing a BottomAppBar containing a Text element to the bottomBar slot of the Scaffold; this text shows the current status (e.g. number of characters typed, selected tab).
5. Below the Toolbar, implement the Tab Bar using TabRow, with three Tab items — "Home", "Profile" and "Settings" — and track the selected tab index using remember { mutableStateOf(0) }.
6. Based on the selected tab index, display different content in the body of the screen.
7. In the content area, add a Label (a Text composable) describing the field, followed by an OutlinedTextField for the user to enter text.
8. Track the TextField's value using remember { mutableStateOf("") } and update the Label/Status Bar text whenever the value changes.
9. Style the Toolbar, Tab Bar and Status Bar using MaterialTheme colors so they are visually distinguished from the content area.
10. Run the application on an emulator/device, switch between tabs, type into the TextField, and verify that the Label and Status Bar update accordingly.

## Source Code Files
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/example/uielements/MainActivity.kt`

## Result
Thus, an Android application demonstrating the use of TextField, Label, Toolbar, Status Bar and Tab Bar UI elements was successfully designed and implemented using Jetpack Compose.
