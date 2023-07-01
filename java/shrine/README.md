# Material Design Tutorial
MDC is a set of components in Java that help developers design app that meet **Material Design** specification. This tutorial will guide you through the process of creating a simple app that uses MDC components.

## Material Design Components
Inorder to use MDC components in your Java app you need to add its dependency in the dependencies block of the build.gradle file of your project. The dependency is as follows:
```gradle
api 'com.google.android.material:material:1.1.0-alpha06'
```

Some of the components that we will be using in this tutorial are:

### TextInputLayout
Text Input Layout is used together with **TextInputEditText** to create a place where users can type and edit text.

An example of how it is used is here:
```xml
<com.google.android.material.textfield.TextInputLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="4dp"
            android:hint="@string/shr_hint_username"
            >

            <com.google.android.material.textfield.TextInputEditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:inputType="text"
                android:maxLines="1"
                />
</com.google.android.material.textfield.TextInputLayout>
```
The **android:hint** attribute is used to specify the hint text.

The **android:inputType** attribute is used to specify the type of input that the user is expected to enter. In this case it is text.

The **android:maxLines** attribute is used to specify the maximum number of lines that the user can enter. In this case it is 1.

### Button
Material Buttons are used to trigger an action or event, such as submitting a form, opening a dialog, canceling an action, or performing a delete operation.

An example of how it is used is here:
```xml
<com.google.android.material.button.MaterialButton
                android:id="@+id/next_button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/shr_button_next"
                android:layout_alignParentEnd="true"
                android:layout_alignParentRight="true"
                />
```
The **android:text** attribute is used to specify the text that will be displayed on the button.

The forms and buttons can be seen on the login page of the Shrine App.