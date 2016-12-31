NODE JS TUTORIAL FOR BEGINNERS - TheNetNinja
https://www.youtube.com/watch?v=w-7RQ46RgxU&list=PL4cUxeGkcC9gcy9lrvMJ75z9maRw4byYp

01.Introduction: {
	- Node.js ACTUALLY is: {
		+ A platform which allows us to run JS on a computer/ server.
		+ Read, delete and update files.
		+ Easily communicate with a database.
	}
	- Why is Node.js so Popular? {
		+ It uses Javascript
		+ Very fast ( runs on the V8 engine & uses non-blocking code)
		+ Huge ecosystem of open source packages (npm)
		+ Greate for real-time services ( like chats)
	}
	- What We will Learn... {
		+ The inner workings of Node.js:
			V8 engine
			Modules
			Event emitter
			The file system
		+ Creating a web server
			Routing
			Express
			Templating
		+ Make a Node.js application (todo app)
	}
	- Editor {
		+ ATOM
			UI Theme: Monokai Tweaked
			Syntax Theme: Atom Monokai
	}
	- Github: https://github.com/iamshaunjp/node-js-playlist
	- What You Need to Know: {
		+ JavaScript
		+ HTML
		+ A tiny bit about the command line
	}
}
02.Installing Node JS: {
	https://nodejs.org/en
	node -v
	
	Atom - File - Settings - Install - packages - "platformio-ide-terminal"
	
	clone github repo from 01: "iamshaunjp/node-js-playlist"
	open by Atom
	add file "app.js", run: node "app"
	
}
03.The V8 Engine: {
	- JavaScript Engines: {
		+ Computers do NOT understand JavaScript.
		+ A JavaScript engine takes JavaScript, and converts it into
		something it does understand - machine code
	}
	- Machine Code: {
		+ Javascript
		+ C++
		+ Assembly Language
		+ Machine Code
	}
	- So... {
		+ Node.js is written in C++
		+ At the heart of Node.js is the V8 engine
			https://developer.google.com/v8
		+ The V8 engine converts our JS into machine code
	}
	- Node.js with V8: {
		+ JavaScript
			--> C++ Node.js V8
	}			--> Machine Code
}
04.