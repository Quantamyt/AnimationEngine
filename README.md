# Animation Engine

[![](https://jitpack.io/v/Quantamyt/AnimationEngine.svg)](https://jitpack.io/#Quantamyt/AnimationEngine)

*powered by JitPack!*

A simple Java animation library that provides utilities for managing animations with customizable easing functions.

## Installation

You can include this library in your project using JitPack.

### Step 1: Add the JitPack repository to your build file

Add the following repository to your `pom.xml` if you are using Maven, or to your `build.gradle` if you are using Gradle:

#### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

### Step 2: Add the dependency

Add the dependency to your `pom.xml` or `build.gradle`:

#### Maven

```xml
<dependency>
    <groupId>com.github.Quantamyt</groupId>
    <artifactId>AnimationEngine</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

you can replace `master-SNAPSHOT` with the version tag you want to use (e.g., `fff5884c33`).

#### Gradle

```groovy
dependencies {
    implementation 'com.github.Quantamyt:AnimationEngine:master-SNAPSHOT'
}
```

you can replace `master-SNAPSHOT` with the version tag you want to use (e.g., `fff5884c33`).

## Usage

### AnimationEngine

```java
import dev.quantam.AnimationEngine;
import java.util.function.Consumer;
import java.util.function.Function;

// Create an animation engine with a callback and easing function

AnimationEngine engine = new AnimationEngine(2.0f, progress -> {
    
    // Update UI or perform action based on animation progress
    
    System.out.println("Animation progress: " + progress);
}, EaseFunctions::easeInOutQuad);

// Start the animation
engine.start();

// Update the animation engine in your game loop or update method

float deltaTime = 0.016f; // Example time between updates in seconds
engine.update(deltaTime);

// Check if animation is still running

if (engine.isRunning()) {
    // Animation is still in progress
} else {
    // Animation has completed
}
```

### AnimationManager

```java
import dev.quantam.AnimationEngine;
import dev.quantam.AnimationManager;

// Create an AnimationManager

AnimationManager manager = new AnimationManager();

// Add animations to the manager

AnimationEngine animation1 = new AnimationEngine(1.5f, progress -> {
    
    // Update UI or perform action based on animation progress
    
}, EaseFunctions::easeInOutCubic);
manager.addAnimation(animation1);

AnimationEngine animation2 = new AnimationEngine(3.0f, progress -> {
    
    // Update UI or perform action based on animation progress
    
}, EaseFunctions::easeInOutExpo);
manager.addAnimation(animation2);

// Update all animations managed by the manager

float deltaTime = 0.016f; // Example time between updates in seconds

manager.update(deltaTime);
```

### EaseFunctions

```java
import dev.quantam.easings.EaseFunctions;

// Example usage of easing functions
float linearValue = EaseFunctions.linear(0.5f);

float easeInOutQuadValue = EaseFunctions.easeInOutQuad(0.3f);

System.out.println("Linear value: " + linearValue);
System.out.println("EaseInOutQuad value: " + easeInOutQuadValue);
```

**Feel Free to check out [AnimationApp](https://github.com/Quantamyt/AnimationEngine/blob/main/src/main/java/dev/quantam/demo/AnimationApp.java) and [AnimationDemo](https://github.com/Quantamyt/AnimationEngine/blob/main/src/main/java/dev/quantam/demo/AnimationDemo.java) for more detailed help.**

## Contributing

Contributions are welcome! If you have improvements or additional features to suggest, please create a pull request. (this is very dirty code :P )

## License

This project is licensed under [CC 4.0](https://creativecommons.org/licenses/by/4.0/?ref=chooser-v1) to [Quantam](https://github.com/Quantamyt/)