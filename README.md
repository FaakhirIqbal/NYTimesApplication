# NYTimesApplication
NYTimes Assignment Application

### Network Api for News Article Data

* api-Key: sybDZly7rUqL8GuOtTFGBKNmcihhCQEX

* getNYTimesDataSet() [http://api.nytimes.com/] defined in app gradle
* Get Service of most popular articles [svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=sybDZly7rUqL8GuOtTFGBKNmcihhCQEX] (Get service communication.NetworkService.class)

### Dependencies in Gradle
 >Can be used many jar files so we need to implement fileThree in gradle file
```sh
implementation fileTree(dir: 'libs', include: ['*.jar'])
```
 >Android support libraries used for user interface design pattern (action bar, navigation drawer, listing items) as well as backward compatible versions of Android framework
```sh
 implementation 'com.android.support:appcompat-v7:26.1.0'
 implementation 'com.android.support:design:26.1.0'
 implementation 'com.android.support.constraint:constraint-layout:1.1.3'
 implementation "com.android.support:recyclerview-v7:26.1.0"
```
 >Time & Date Formatting library
```sh 
 implementation 'org.ocpsoft.prettytime:prettytime:4.0.1.Final'
```
 >Library used for automated Unit Testing 
```sh 
 androidTestImplementation 'com.android.support.test:runner:1.0.2'
 androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
```
 >Added to the same in build.gradle file the following line in android.defaultConfig:
```sh 
testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
```
 >OkHttp that logs HTTP request and response data
 ```sh
 implementation 'com.squareup.okhttp3:logging-interceptor:3.8.0'
 ```
 >A Compile-time dependency injection framework added for simplifies the DI into Android components
 ```sh
  annotationProcessor 'com.google.dagger:dagger-compiler:2.0'
  implementation 'com.google.dagger:dagger:2.2'
 ``` 
  >Library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent object
 ```sh
 implementation 'com.google.code.gson:gson:2.8.2'
 ```
 >Retrofit library is a REST Client for Java and Android, An easy JSON uploading and retrieving, It use the OkHttp library for HTTP requests
 ```sh
 implementation 'com.squareup.retrofit2:retrofit:2.3.0'
 implementation 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
 implementation 'com.squareup.okhttp3:okhttp:3.10.0'
 implementation 'com.squareup.retrofit2:converter-gson:2.0.1'
 ```
 >RxJava Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM
 ```sh
 implementation 'io.reactivex:rxandroid:1.2.1'
 implementation 'io.reactivex:rxjava:1.1.6'
 ```
 > Library used for common annotations For The Java Platform and for Dagger2 dependency
 ```sh
 compileOnly 'javax.annotation:jsr250-api:1.0'
 ```
 > An image loading and caching library for Android
 ```sh
   implementation 'com.github.bumptech.glide:glide:3.8.0'
 ```
 
 

 
 
### How to run project 
- To run Project Unzip the github project to a folder. Open Android Studio. Go to File -> New -> Import Project.
   Then choose the project import and then click Next -> Finish.
   Or
- If you have git integrated with android studio you need to Import the Git(https://github.com/FaakhirIqbal/NYTimesApplication) project to Android Studio.

### Application architecture and hierarchy
There are packages each of them showing there functionality by its name
like layout folder contains all xml file views of they screen News Article listing and News Article details with the name
 [news_article_recycle.xml] &
 [news_article_detail_view.xml]

* adapter --> [NewsAdapter.java] which is populating earch row of recycleView of News Article

* communication --> Network and New York Times Api calling related work has done in that package

* controllor --> Two main Fragments Screen 
   - [NewsArticleFragment.java]
   - [NewsArticleDetailFragment.java] which are inflating in [MainActivity.java]

* customView --> all the customization of layout and datafields(like: TextView EditText Button radioButton etc) modification package

* database --> Phone Local database operation for saving data from any API as needed, as per requirement I didnot added details in these classes

* model --> all Beans/Objects are added in this package

* utility --> all utility classes can be added in this package like DateFormation, networks api and other common constants 

* manifeast --> MainActivity Launcher class and BaseApplication and it contains all the details needed by the android system about the application.

* TestCases --> Right now I have not added testcases but I have added basic files in Package I will do once I got spare time.
