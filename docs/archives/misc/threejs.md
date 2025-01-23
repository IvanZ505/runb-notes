# ThreeJS Journey

***Resources to use***

- [ThreeJS Official Page](https://threejs.org)
	- [Documentation](https://threejs.org/docs/index.html#manual/en/introduction/Creating-a-scene)
<br></br>

- Finding textures
	- [poliigon.com](https://www.poliigon.com/)
	- [3dtextures.me](https://www.3dtextures.me/)
	- [arroway-textures.ch](https://www.arroway-textures.ch)
---

## Table of Contents

[Textures](#textures)

---

## Textures

*What are textures?*

> Textures are images that cover the surface of all your geometries. They have many different types that help to change the appearance of your geometry.

---

#### There are many different types of textures...

Find out about it by going to [ThreeJS Journey Textures](https://threejs-journey.com/lessons/textures#color-or-albedo).

---

#### Two Ways of Loading Textures

*To get the URL of the Image:*

1. Put image texture in `/src/` folder and import it like a JS dependency. 

```javascript

import imageSource from './image.png'

console.log(imageSource)

```

2. Put image texture in the `/static/` folder and access it just from the path of the image without the need to import.

```js

const imageSource = '/image.png'

console.log(imageSource)

```

*To Load the Image:*

1. Use the native JS route with assigning a `Image()` variable and then change the source to the image file path.
2. Use the ThreeJS `TextureLoader`. 

## Materials

What are materials?
- Materials are used to put a color on each visible pixel of the geometries.
