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
04.The Global Object {
	- JavaScript on browser: The Global Object is window.
	- Node.Js: The Global Object provide some ready functions:
		clearImmediate, console, exports, global, module...
		https://nodejs.org/api/globals.html
	
	- app.js: {
		+ console.log(""hey ninjas);
		
		+ setTimeout(function(){
			console.log("3 seconds have passed");
		},3000);
		
		+ var time = 0;
		setInterval(function() {
			time += 2;
			console.log(time  + " seconds have passed");
		}, 2000);
		
		+ var time1 = 0;
		var timer = setInterval(function() {
			time1 += 3;
			console.log(time1 + " seconds have passed...");
			if (time1 > 10) {
				clearInterval(timer);
			}
		}, 2000);
		
		+ console.log(__dirname);
		+ console.log(__filename);
	}
	
}
05.Function Expressions {
	- Normal function statement {
		function sayHi() {
			console.log("hi");
		}
		sayHi();
	}
	
	- Function expression: {
		var sayBye = function() {
			console.log("bye");
		}
		sayBye();
	}
	
	- Pass function as parameter: {
		function callFunction(fun) {
			fun();
		}
		
		callFunction(sayBye);
	}
}
06.Modules and require() {
	- count.js: {
		var counter = function(arr) {
			return "There are " + arr.length + " elements in this array";
		};
		module.exports = counter;
	}
	- app.js: {
		var counter1 = require("./count"); //count.js
		console.log(counter1([1, 2, 3, 4, 'x']);
	}
}
07.Module Patterns {
	- stuff.js: {
		var counter = function(arr) {
			return "There are " + arr.length + " elements in this array.";
		};
		
		var adder = function(a, b) {
			return `The sum of the 2 numbers ${a} and ${b} is ${a + b}`;
		};
		
		var pi = 3.14;
		
		module.exports.counter = counter;
		module.exports.adder = adder;
		module.exports.pi = pi;
		
		//or:
		
		module.exports = {
			counter: counter,
			adder: adder,
			pi: pi
		};
	}
	
	- app.js: {
		var stuff = require("./stuff");
		
		console.log(stuff.counter([ 1, 2, 3]));
		console.log(stuff.adder(5, 6));
		console.log(stuff.adder(stuff.pi, 5));
	}
}
08.The Node Event Emitter {
	- app.js: {
		var events = require("events");
		
		var myEmitter = new events.EventEmitter();
		
		myEmitter.on("someEvent", function(msg) {
			console.log(msg);
		});
		
		myEmitter .emit("someEvent", "The event was emitted");
	}
	- app1.js {
		var events = require('events');
		var util = require('util');
		
		var Person = function(name) {
			this.name = name;
		};
		
		util.inherits(Person, events.EventEmitter);
		
		var james = new Person("james");
		var mary = new Person("mary");
		var ryu = new Person("ryu");
		
		var people = [james, mary, ryu];
		
		people.forEach(function(person)) {
			person.on("speak", function(msg) {
				console.log(person.name + " said: " + msg);
			});
		});
		
		james.emit("speak", "hey dudes");
		ryu.emit("speak", "I want a curry");
	}
}
09.Reading & Writing Files(fs) {
	- Sync approach: {
		var fs = require("fs");
	
		var readMe = fs.readFileSync("readMe.txt", "utf8");
		console.log(readMe);
	
		fs.writeFileSync("writeMe.txt", readMe);
	}
	- Async approach: {
		var fs = require("fs");
		fs.readFile("readMe.txt", "utf8", function(err, data) {
			console.log(data);
			fs.writeFile("writeMe.txt", data);
		});
		console.log("Test");
	}
}
10.Creating & Removing Directories {
	- Sync approach: {
		var fs = require("fs");
	
		fs.unlink("writeMe.txt");
		fs.mkdirSync("stuff");
		fs.rmdirSync("stuff"); 
	}
	- Async approach: {
		var fs = require("fs");
		
		fs.mkdir("stuff", function() {
			fs.readFile("readMe.txt", "utf8", function(err, data) {
				fs.writeFile("./stuff/writeMe.txt", data);
			});
		});
	}
	- Remove directory: {
		fs.unlink("./stuff/writeMe.txt", function() {
			fs.rmdir("stuff");
		});
	}
}
11.