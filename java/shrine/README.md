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

### AppBar
We add an appbar using the AppBarLayout and ToolBar MDC components. The toolbar contains the menus and text that is seen on the appbar. An example of this is shown below:
```xml
<com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <androidx.appcompat.widget.Toolbar
            android:id="@+id/app_bar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            style="@style/Widget.Shrine.Toolbar"
            app:title="@string/shr_app_name"
            app:navigationIcon="@drawable/shr_menu"
            />
    
</com.google.android.material.appbar.AppBarLayout>
```
**app:title** is used to set the title seen on the app bar.
**app:navigationIcon** is used to set what icon to use for navigation

A menu is added programmatically to the toolbar. [MDC Toolbar Tutorial](https://codelabs.developers.google.com/codelabs/mdc-102-java/index.html#2) explains how this is done. The implemented code can be seen in the ProductGridFragment.java file.

### MaterialCard
This is used to display content and actions on a single subject. They're a flexible way to present similar content as a collection

An example implementation of a card:
```xml
<com.google.android.material.card.MaterialCardView
        android:layout_width="160dp"
        android:layout_height="180dp"
        android:layout_marginTop="70dp"
        android:layout_marginLeft="16dp"
        android:layout_marginBottom="16dp"
        android:layout_marginRight="16dp"
        app:cardBackgroundColor="?attr/colorPrimaryDark"
        app:cardCornerRadius="10dp"
        >

        <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            android:orientation="vertical"
            android:background="#FFFFFF"
            android:padding="8dp"
            >

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/shr_product_title"
                android:padding="2dp"
                android:textAppearance="?attr/textAppearanceHeadline6"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:padding="2dp"
                android:text="@string/shr_product_description"
                android:textAppearance="?attr/textAppearanceBody2"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

</com.google.android.material.card.MaterialCardView>
```

## Connceting Layout To Logic In Activities
### Listening to Events
To listen to an event you need to **create an event listener** in the **onCreate()** or **onCreateView()** methods of your Activity or Fragment respectively.

To create an event listener we do the following:
1. **Get The Widget You Want To Listen To** - We get the widget that we want to listen to using the findViewById() command. 
2. **Create The Listener** - We create the listener for the event that we want. In this example we create an onClick listener
```java
public class Activity extends Activity{
    @Override
    public void onCreate(Bundle savedInstance) {
        // Some code
        
        MaterialButton nextButton = view.findViewById(R.id.next_button);
        
        nextButton.setOnClickListener(new View.onClickListener() {
           @Override
           public void onClick(View v) {
               // Perform some logic
           } 
        });
    }
}
```

# Some Common Libraries
## Volley
Volley library is used to handle networking in Android.

It is able to:
1. Make HTTP Requests
2. Cache results to the response

To use volley we do the following:
1. Add the dependency by adding the following to build.gradle in the dependencies section i.e 
```gradle
dependencies {
    //
    implementation 'code.android.volley:volley:1.0.0'
}
```
2. Add the internet permission in the manifest
```xml
<uses-permission android:name='android.permission.INTERNET' />
```

Volley also comes with some prebuilt widgets like the NetworkImage that makes it easy to get images from the internet and add them to your layout
```xml
<com.android.volley.toolbox.NetworkImageView
    android:id="@+id/product_image"
    android:layout_width="match_parent"
    android:layout_height="@dimen/shr_product_card_image_height"
    android:background="?attr/colorPrimaryDark"
    android:scaleType="centerCrop"/>
```

# Miscellaneous
## Adapter
Adapters are objects that bridge the gap between data and our UI. Let's say we want to display a list of all the cars that are in a particular database. To do this we would need to **get the data from the database and give it to our list to display**. This is what the Adapter does.

Adapters **get data from a data source and sends the data to an AdapterView**. AdapterView are UI elements that display the data gotten from an Adapter. There are different types of AdapterViews:
1. **ListView** - takes the data and presents it as a column
2. **GridView** - takes the data and presents it as a grid or table
3. **Spinner** - takes the data and puts it in things like dropdowns. They are used when you want to give the user a choice to pick items from a list.

## RecyclerView API
Info gotten from this [site](https://www.grokkingandroid.com/first-glance-androids-recyclerview/)

This API is used when we want to display data that changes on runtime due to user actions or network events

This API was created to deal with cases where one has to display more data than can be fit on the screen. What it does is that it allows the device to **reuse and recycle** views once they are no longer visible rather than storing all of them in memory.

Some of the classes provided in the API include:
1. **Adapter** - this is used to get the data to put in the view from a data source. It is also responsible for the correct layout of individual items. It has 3 methods that need to be implemented:
```java
public VH onCreateViewHolder(ViewGroup parent, int viewType)
public void onBindViewHolder(VH holder, int position)
public int getItemCount()
```
2. **ViewHolder** - acts as a cache of View Objects
3. **LayoutManager** - responsible for the layout of all child views.
4. **itemDecoration** - can add an offset to each item, modify the item etc. A recyclerView can have multiple itemDecorations. ItemDecoration has the following methods:
```java
public void onDraw(Canvas c, RecyclerView parent)
public void onDrawOver(Canvas c, RecyclerView parent)
public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)
```
5. **itemAnimator** - is used to deal with the animation of items when they are added to a dataset, removed from a dataset, moves as a result of one of the previous operations. There is a default itemAnimator provided.

The general process of using recyclerView is to:
1. Add the RecyclerView widget to the XML
2. Get the view in the Java code
3. Create a layout manager and add it to the recyclerView.
4. If all items will be of the same size set setHasFixedSize to true.
5. Create an adapter and add it to recyclerView.
6. Create itemDecorations if needed and add to recyclerView
7. Create animator if needed or set recyclerView's animator to the default.
8. Create listeners if needed and add to recyclerView