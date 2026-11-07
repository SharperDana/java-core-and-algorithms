# Java Core, Data Structures & Image Processing Portfolio

An organized collection of core Java implementations focusing on **2D/3D matrix manipulations for image processing**, **object-oriented geometric engines with collision detection**, **custom data structures**, and **foundational string/recursion algorithms** — built from scratch using standard Java libraries.

---

## 📂 Repository Structure

* **`01-Image-Processing/`**
  * `Ex2.java` — 3D RGB matrix processing, convolution smoothing, rotation & scaling
* **`02-String-and-Recursion-Algorithms/`**
  * `Ex3.java` — Subsequence matching, O(n) string manipulation & recursion
  * `MyConsole.java` — Standard I/O utility wrapper
* **`03-2D-GeoShapes-Engine/`**
  * `Circle.java` — 2D Circle primitive with distance-squared intersection logic
  * `Rectangle.java` — 2D Axis-Aligned Rectangle with AABB collision detection
  * `LinkedList.java` — Custom singly linked list implementation
  * `Node.java` — Linked list node encapsulating GeoShape objects

---

## 🚀 Modules Overview

### 1. Matrix-Based Image Processing (`01-Image-Processing`)
Direct pixel-level image manipulation representing RGB images as 3D tensors (`int[3][height][width]`) and grayscale images as 2D matrices (`int[height][width]`):

* **Luminance Grayscale Conversion (`rgb2gray`):** Converts 3-channel RGB images into 2D grayscale representations using weighted human-perception luminance ratios:
  `Y = 0.30 * R + 0.59 * G + 0.11 * B`
* **Spatial Convolution / Box Blur (`smooth`):** Implements a sliding `(2n + 1) x (2n + 1)` kernel across all RGB channels with dynamic boundary handling to prevent edge darkening.
* **2D Affine Rotation (`rotate_alpha`):** Rotates images by an arbitrary angle `alpha` around their center pivot `(i0, j0)` using trigonometric transformation matrices:
  * `i' = (i1 - i0) * cos(alpha) - (j1 - j0) * sin(alpha) + i0`
  * `j' = (i1 - i0) * sin(alpha) + (j1 - j0) * cos(alpha) + j0`
* **Nearest-Neighbor Scaling (`scaleImg`) & Region Cropping (`crop`):** Supports arbitrary spatial resizing and sub-matrix extraction.

---

### 2. String & Recursive Algorithms (`02-String-and-Recursion-Algorithms`)
Clean algorithmic solutions demonstrating time and space efficiency:

* **Two-Pointer Subsequence Verification (`deletions`):** Determines in `O(|s|)` linear time whether target string `t` can be formed by deleting characters from source string `s`.
* **Linear-Time Word Reversal (`sentence`):** Reverses word order in `O(n)` time using `StringBuilder` to avoid immutable string concatenation overhead.
* **Password Policy Validator (`validPassword`):** Single-pass character classification verifying length, numeric digits, special symbols, and whitespace constraints.
* **Recursive Quotient Calculation (`divide`):** Computes integer division `a / b` via recursive subtraction.

---

### 3. 2D Geometric Shapes & Custom Linked List (`03-2D-GeoShapes-Engine`)
An object-oriented module (`GameEx_Final` package) modeling 2D geometric entities, rendering via `java.awt.Graphics`, and managing collections using a custom-built data structure:

* **Polymorphic Shapes (`Circle`, `Rectangle`):** Implements the `GeoShape` interface with position translation (`translateX`, `translateY`), RGB color encapsulation, and AWT canvas drawing.
* **Optimized Collision Detection (`intersects`):**
  * **Circle–Circle:** Uses squared Euclidean distance `(dx^2 + dy^2) < (r1 + r2)^2` to avoid expensive `Math.sqrt()` operations during real-time checks.
  * **Circle–Rectangle & Rectangle–Rectangle:** Implements Axis-Aligned Bounding Box (AABB) overlap detection.
* **Custom Singly Linked List (`LinkedList`, `Node`):** Full implementation of `LinkedListInterface` and `NodeInterface` from scratch, supporting tail insertion (`add`), pointer-safe node removal (`remove`), and cycle prevention.

---

## 🛠️ Technologies & Concepts Demonstrated

* **Language:** Java (Core SE, `java.awt`)
* **Computer Science Fundamentals:** 2D/3D Array Manipulation, Linear Algebra in Graphics, Pointers & Linked Data Structures, Polymorphism, Recursion, Two-Pointer Technique.
