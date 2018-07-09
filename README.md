# OutlineSpan
Library (just one class) for outlining TextView.

## How to use
Use android's [Spannable](http://github.comhttps://developer.android.com/reference/android/text/Spannable) class for changing style of part of text.
``` Kotlin
val outlineSpan = OutlineSpan(
    strokeColor = Color.RED,
    strokeWidth = 4F
)
val text = "Outlined text"
val spannable = SpannableString(text)
spannable.setSpan(outlineSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

// Set text of TextView
binding.outlinedText.text = spannable 
```
Result:

<img src="https://raw.githubusercontent.com/santaevpavel/OutlineSpan/master/Raw/outlinedText.png" width="350"/>

# Download (Gradle)

Add Jitpack repository:
```
repositories {
    maven { url 'https://jitpack.io' }
}
```
Add dependency: 
```
dependencies {
    implementation 'com.github.santaevpavel:OutlineSpan:0.1.0'
}
```
If you don't want to add dependency, you can copy class [OutlineSpan](https://gist.github.com/santaevpavel/61eb23092bdb8a926aeb8302ec95b4b6) to your project.

# Sample
[Link](https://github.com/santaevpavel/OutlineSpan/tree/master/Sample)
