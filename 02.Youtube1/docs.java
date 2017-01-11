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
11.Clients and Servers {
	- Client<---(req, res)---> Server
	- Protocols: {
		A set of communication rules, that two sides agree to use when communicating
		(language)
	}
	- Client:Ips<---Socket--->Server:Ips
			    (Channel)
	- TCP: packets sent along the socket
	- Ports: {
		A program running on a computer can listen for requests sent to a particular port number,
		E.g. 172.24.86.76:3000
	}
}
12.Creating a Server {
	- Response Header: {
		Client --Request(req + req headers)-->Server
		Client <--Response(res data + res headers)-- Server
		Response Headers: {
			- Content-Type
			- Status
		}
	}
	- app.js: {
		var http = require("http");
		var server = http.createServer(function(req, res) {
			console.log("request was made: " + req.url);
			res.writeHead(200, {"Content-Type": "text/plain"});
			res.end("Hey ninjas");
		});
		server.listen(3000, "127.0.0.1");
		console.log("yo dawgs, now listening to port 3000");
	}
}
13.Streams and Buffers {
	- Node.js Candy Mountain
	- Buffer: {
		+ Temporary storage spot for a chunk of data that is being transferred
			from one place to another.
		+ The buffer is filled with data, then passed along.
		+ Transfer small chunks of data at a time.
	}
	- Streams in Node.js: {
		+ Can create streams in Node.js to transfer data.
		+ Increase performance.
	}
}
14.Readable Streams {
	- Streams: {
		+ Writable streams - allow node js to write data to a stream
		+ Readable streams - allow node js to read data from a stream
		+ Duplex - can read and write to a stream
	}
	- Readable Streams: {
		var fs = require("fs");		
		var myReadStream = fs.createReadStream(__dirname + "/readMe.txt", "utf8");
		
		myReadStream.on("data", function(chunk) {
			console.log("New chunk received:\n" + chunk);
		});
	}
}
15.Writable Streams {
	var myWriteStream = fs.createWriteStream("writeMe.txt");
	
	myReadStream.on("data", function(chunk) {
		console.log("New chunk received: " + chunk);
		myWriteStream.write(chunk);
	});
}
16.Pipes {
	{ myReadStream.pipe(myWriteStream); }
	or {
		var http = require("http");
		var fs = require("fs");
		
		var server = http.createServer(function(req, res) {
			console.log("request was made: " + req.url);
			res.writeHead(200, {"Content-Type": "text/plain"});
			var myReadStream = fs.createReadStream("readMe.txt", "utf-8");
			myReadStream.pipe(res);
		});
		
		server.listen(3000, "127.0.0.1");
		console.log("yo dawgs, now listening to port 3000");
	}
}
17.Serving HTML Pages {
	- index.html: html
	- app.js: {
		res.writeHead(200, {"Content-Type": "text/html"});
		var myReadStream = fs.createReadStream("index.html", "utf8");
		myReadStream.pipe(res);
	}
}
18.Serving JSON data: {
	- app.js: {
		var myObj = {
			name: "Ryu",
			job: "Ninja",
			age: 29
		};
		res.end(JSON.stringify(myObj));
	}
}
19.Basic Routing: {
	- contact.html
	- 404.html
	- app.js: {
		var server = http.createServer(function(req, res) {
			....
			if (req.url === '/home' || req.url === '/') {
				res.writeHead(200, {"Content-Type": "text/html"});
				fs.createReadStream(__dirname + "/index.html").pipe(res);
			} else if (req.url === '/contact') {
				res.writeHead(200, {"Content-Type": "text/html"});
				fs.createReadStream(__dirname + "/contact.html").pipe(res);
			} else if (req.url === "/api/ninjas") {
				var ninjas = [{name: "ryu", age: 29}, {name:"yoshi", age: 32}];
				res.writeHead(200, {"Content-Type": "application/json"});
				res.end(JSON.stringify(ninjas));
			} else {
				res.writeHead(404, {"Content-Type": "text/html"});
				fs.createReadStream(__dirname + "/404.html").pipe(res);
			}
		});
	}
}
20.The Node Package Manager: {
	- website: https://npmjs.com
	- npm init
	- npm install express
}
21.The 'package.json' file: {
	- npm init -> generates package.json.
	- package.json: keeps track which packages our app depends on.
	- npm install express -save -> save package dependencies into package.json
	- npm uninstall express -> remove express from node_modules but still keep it in package.json
	- npm install -> install all package dependencies listed in package.json.
}
22.Installing Nodemon {//hot reload app
	- npmjs.com -> search nodemon
	- npm install -g nodemon
	- nodemon app.js
}
23.Express {
	https://www.youtube.com/watch?v=9TSBKO59u0Y&index=23&list=PL4cUxeGkcC9gcy9lrvMJ75z9maRw4byYp
	- Express: {
		+ Easy and flexible routing system
		+ Integrates with many templating engines
		+ Contains a middleware framework
	}
	- HTTP Methods: {
		+ GET
		+ POST
		+ DELETE
		+ PUT
	}
	- Responding to Requests: {
		+ GET: - app.get('route', fn);
		+ POST: - app.post('route', fn);
		+ DELETE: - app.delete('route', fn);
	}
	
	npm install -save express
	- app23.js: {
		var express = require("express");
		var app = express();
		
		app.get("/", function(req, res) {
			res.send("This is the homepage");
		});
	
		app.get("/contact", function(req, res) {
			res.send("This is the contact page");
		});
	
		app.listen(3000);
	}
	nodemon app
}
24.Route Parameters: {
	- app.get("/profile/:name", function(req, res) {
		res.send("You requested to see a profile with the name of " + req.params.name);
	});
}
25.Templating Engines: {
	- res.sendFile({{HTMl file}}): {
		+ get('/') -> res.sendFile(__dirname + "/index.html");
		+ get("/contact") -> res.sendFile(__dirname + "/contact.html");
	}	
	- http://embeddedjs.com      //EJS
	- npm install ejs -save
	- app.set("view engine", "ejs");
	- create: views\profile.ejs { // copy mostly from index.html
		<%= person %>
	}
	- res.render("profile", {person: req.param.name});
}
26.Template Engines (part 2) {
	- app.js: {
		var data = {age: 29, job: "ninja", hobbies: ['eating', 'fighting', 'fishing']};
		res.render("profile", {person: req.params.name, data: data});
	}
	- view/profile.ejs: {
		<style>
			h2 {font-size: 30px;}
			li {font-size: 16px;}
		</style>
		
		<h2>
			<ul>
				<%data.hobbies.forEach(function(item){ %>
					<li><%= item%></li>
				<%	});	%>
			</ul>
		</h2>
	}
}