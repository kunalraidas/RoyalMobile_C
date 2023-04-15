package com.kunalashish.royalmobilec.utils


// <com.google.android.material.card.MaterialCardView
//
//        android:layout_marginBottom="16dp"
//        app:cardCornerRadius="14dp"
//        app:cardBackgroundColor="@color/white"
//        app:cardElevation="0dp"
//        android:background="@color/white"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        tools:ignore="MissingConstraints">
//
//        <androidx.constraintlayout.widget.ConstraintLayout
//            android:layout_margin="6dp"
//            android:layout_width="match_parent"
//            android:layout_height="match_parent">
//
//            <ImageView
//                android:clickable="true"
//                android:src="@drawable/phone"
//                android:id="@+id/imgCart"
//                android:layout_width="70dp"
//                android:layout_height="70dp"
//                app:layout_constraintTop_toTopOf="parent"
//                app:layout_constraintLeft_toLeftOf="parent"
//                app:layout_constraintBottom_toBottomOf="parent"
//                app:layout_constraintStart_toStartOf="parent"/>
//
//            <LinearLayout
//                android:layout_marginLeft="4dp"
//                android:orientation="vertical"
//                android:id="@+id/linearCartDetails"
//                app:layout_constraintLeft_toRightOf="@id/imgCart"
//                app:layout_constraintTop_toTopOf="parent"
//                app:layout_constraintBottom_toBottomOf="parent"
//                android:layout_width="wrap_content"
//                android:layout_height="match_parent">
//
//                <TextView
//                    android:id="@+id/txtCartItemProductName"
//                    android:text="Iphone 14 Pro Max Ulter"
//                    android:fontFamily="@font/montserrat"
//                    android:textColor="@color/title_text_color"
//                    android:textSize="16sp"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"/>
//
//                <TextView
//                    android:id="@+id/txtCartItemQuantity"
//                    android:text="Quantity : 1"
//                    android:textSize="14sp"
//                    android:fontFamily="@font/montserrat"
//                    android:textColor="@color/black"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"/>
//
//                <TextView
//                    android:id="@+id/txtCartItemTotal"
//                    android:text="Total : Rs 49999/-"
//                    android:textSize="14sp"
//                    android:fontFamily="@font/montserrat"
//                    android:textColor="#048F55"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"/>
//
//            </LinearLayout>
//
//            <ImageView
//                android:clickable="true"
//                android:foreground="?attr/selectableItemBackground"
//                android:layout_marginTop="6dp"
//                app:layout_constraintTop_toTopOf="parent"
//                app:layout_constraintRight_toRightOf="parent"
//                app:layout_constraintEnd_toEndOf="parent"
//                android:id="@+id/btnRemoveCartItem"
//                android:scaleType="centerCrop"
//                android:src="@drawable/trash_can"
//                android:layout_width="26dp"
//                android:layout_height="26dp"
//                />
//
//
//            <LinearLayout
//                app:layout_constraintTop_toBottomOf="@id/btnRemoveCartItem"
//                app:layout_constraintBottom_toBottomOf="parent"
//                app:layout_constraintEnd_toEndOf="parent"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_marginRight="10dp"
//                android:layout_marginTop="4dp"
//                android:orientation="horizontal">
//
//                <!--
//                <EditText
//                    android:gravity="center"
//                    android:textSize="12sp"
//                    android:inputType="number"
//                    android:hint="Quantity"
//                    android:id="@+id/edCartQuantity"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_marginRight="10dp"/>
//
//                <TextView
//                    android:clickable="true"
//                    android:foreground="?attr/selectableItemBackground"
//                    android:textSize="12sp"
//                    android:paddingBottom="6dp"
//                    android:paddingTop="4dp"
//                    android:fontFamily="@font/montserrat"
//                    android:paddingHorizontal="20dp"
//                    android:id="@+id/btnUpdateCart"
//                    android:background="@drawable/normal_button_bg"
//                    android:text="Update"
//                    android:textColor="@color/white"
//                    android:textAllCaps="false"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"/>
//                    -->
//<!--                <ImageView-->
//<!--                    android:clickable="true"-->
//<!--                    android:foreground="?attr/selectableItemBackground"-->
//<!--                    android:id="@+id/btnMinusCart"-->
//<!--                    android:src="@drawable/ic_baseline_horizontal_rule_24"-->
//<!--                    android:background="@drawable/round_button_bg"-->
//<!--                    android:layout_width="24dp"-->
//<!--                    android:layout_height="24dp"-->
//<!--                    android:padding="6dp"/>-->
//
//<!--                <TextView-->
//<!--                    android:textSize="18sp"-->
//<!--                    android:fontFamily="@font/montserrat"-->
//<!--                    android:layout_gravity="center"-->
//<!--                    android:layout_marginLeft="8dp"-->
//<!--                    android:id="@+id/txtCartItemQuantityText"-->
//<!--                    android:text="0"-->
//<!--                    android:textColor="@color/title_text_color"-->
//<!--                    android:layout_width="wrap_content"-->
//<!--                    android:layout_height="wrap_content"/>-->
//
//<!--                <ImageView-->
//<!--                    android:layout_marginLeft="8dp"-->
//<!--                    android:clickable="true"-->
//<!--                    android:foreground="?attr/selectableItemBackground"-->
//<!--                    android:id="@+id/btnPlusCart"-->
//<!--                    android:src="@drawable/ic_baseline_add_24"-->
//<!--                    android:background="@drawable/round_button_bg"-->
//<!--                    android:layout_width="24dp"-->
//<!--                    android:layout_height="24dp"-->
//<!--                    android:padding="4dp"/>-->
//
//            </LinearLayout>
//        </androidx.constraintlayout.widget.ConstraintLayout>
//
//    </com.google.android.material.card.MaterialCardView>
// activity.xml file code for drawer Layout
//
//<androidx.coordinatorlayout.widget.CoordinatorLayout
//android:id="@+id/coordinatorlayout"
//android:layout_width="match_parent"
//android:layout_height="match_parent">
//
//<com.google.android.material.bottomnavigation.BottomNavigationView
//android:id="@+id/bottom_navigation"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:layout_alignParentBottom="true"
//android:layout_gravity="bottom"
//app:itemBackground="@color/purple_500"
//android:background="?android:attr/windowBackground"
//android:foreground="?attr/selectableItemBackground"
//app:itemIconTint="@drawable/selector"
//app:itemTextColor="@drawable/selector"
//app:menu="@menu/buttom_item" />
//
//
//<FrameLayout
//android:id="@+id/frame"
//android:layout_width="fill_parent"
//android:layout_height="fill_parent"
//android:layout_marginBottom="56dp">
//
//<com.google.android.material.appbar.AppBarLayout
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:theme="@style/Theme.AppCompat.DayNight.DarkActionBar"
//android:elevation="0dp">
//
//<androidx.appcompat.widget.Toolbar
//android:id="@+id/toolbar"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//app:title="Royal_Mobile"
//app:menu="@menu/search_icon"
//android:minHeight="?attr/actionBarSize"
//android:background="@color/primary_color"
//app:layout_scrollFlags="scroll|enterAlways"/>
//
//</com.google.android.material.appbar.AppBarLayout>
//</FrameLayout>
//
//
//
//
//</androidx.coordinatorlayout.widget.CoordinatorLayout>
//
//
//
//<com.google.android.material.navigation.NavigationView
//android:visibility="gone"
//android:id="@+id/NavigationView"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//app:headerLayout="@layout/drawer_header"
//app:menu="@menu/menu_drawer"
///>
//

//<!--        <ImageView-->
//<!--            android:id="@+id/img_banner"-->
//<!--            android:layout_width="wrap_content"-->
//<!--            android:layout_height="wrap_content"-->
//<!--            android:layout_marginStart="-2dp"-->
//<!--            android:layout_marginTop="-71dp"-->
//<!--            android:layout_marginBottom="-9dp"-->
//<!--            android:src="@drawable/mobile_banner1" />-->