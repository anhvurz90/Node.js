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
	- create: 'views\profile.ejs' { // copy mostly from index.html
		<%= person %>
	}
	- res.render("profile", {person: req.param.name});
}
26.Template Engines (part 2) {
	- app.js: {
		var data = {age: 29, job: "ninja", hobbies: ['eating', 'fighting', 'fishing']};
		res.render("profile", {person: req.params.name, data: data});
	}
	- 'views/profile.ejs': {
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
27.Partial Templates {
	- create 'views/partials' folder.
	- create 'views/partials/nav.ejs': {
		<nav>
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="/contact">Contact</a></li>
			</ul>
		</nav>
	}
	- 'views/profile.ejs': {
		+ <% include partials/nav.ejs %>
	}
	- 'views/index.ejs': { //copy from index.html
		+ <% include partials/nav.ejs %>
	}
	- 'views/contact.ejs': { //copy from contact.html
		+ <% include partials/nav.ejs %>
	}
}
28.Middleware & Static Files {
	- 'view/index.ejs': {
		move css into 'assets/style.css':
		<head>
			<link href="/assets/styles.css" rel="stylesheet" type="text/css"/>
		</head>
	}
	- Middleware: the code running between the request & the response (in the middle)
	- 'app.js': {
		app.use("/assets", function(req, res, next) {
			console.log(req.url);
			next();//if not called, request will be stopped
		});
		->
		app.use("/assets", express.static("assets"));
		//	this is the route		this is the folder name
	}
}
29.Query Strings: {
	- examples: {
		+ mysite.com/blog/news?page=2
		+ Page = 2
		+ mysite.com/contact?person=ryu&dept=marketing
		+ Parse the request, and pull out the data
	}
	- localhost:3000/contact?dept=marketing&person=joe
	- app.js: {
		app.get("/contact", function(req, res) {
			console.log(req.query);
			res.render('contact', {qs: req.query});			
		});
	}
	- contact.ejs: {
		...
		<p><%=qs.dept%></p>
		...
		<form id="contact-form">
			<label for="who">Who do you want to contact?</label>
			<input type="text" name="who" value="<%=qs.person%>">
			<label for="department">Which department?</label>
			<input type="text" name="department" value="<%=qs.dept%>">
			<label for="email">Your email</label>
			<input type="text" name="email"/>
			<input type="submit" value="submit"/>
		</form>
	}
}
30.Handling POST Requests: {
	- POST Requests: {
		+ POST is a request method
		+ POST requests, ask the server to accept/store data which is
			enclosed in the body of the request
		+ Often used when submitting forms
	}
	- contact.ejs: {
		<form id="contact-form" method="POST" action="/contact">
			
		</form>
	}
	- body-parser: {
		+ https://www.npmjs.com/package/body-parser
		+ npm install body-parser
		+ Parse incoming request bodies in a middleware before your handlers, 
		available under the req.body property.
	}
	- app.js: {
		 var body-parser = require("body-parser");
		 var jsonParse = bodyParser.json();
		 var urlencodedParser = bodyParser.urlencoded({extended: false});
		
		app.post("/contact", urlencodedParser, function(req, res) {
			console.log(req.body);
			res.render("contact-success", {data: req.body});			
		});
	}
	- 'view/contact-success.ejs': {
		<body>
			<% include partials/nav.ejs %>
			<h1>Contact Us!</h1>
			<p>Thanks for getting in touch!</p>
			<p>You contacted <%= data.who %> in the <%= data.department%> department.</p>
			<p>We will reply to you at <%= data.email %></p>
		</body>
	}
	- nodemailer: https://www.npmjs.com/package/nodemailer
}
31.Making a To-do App (part 1): {
	- node-js-playlist
	- node-js-playlist/public/assets/: {
		+ logo.png
		+ styles.css
		+ todo-list.js
	}
	- npm init --> package.json
	- npm install express -save
	- npm install ejs -save
	- npm install body-parser -save
}
32.Making a To-do App (part 2): {
	- app32.js: {
		var express = require("express");
		var todoController = require("./controllers/todoController");
		var app = express();
		
		//set up template engine
		app.set("view engine", "ejs");
		
		//static files
		app.use(express.static("./public"));
		
		//fire controllers
		todoController(app);
		
		//listen to port
		app.listen(3000);
		console.log("You are listening to port 3000");
	}
	- MVC {
		+ CONTROLLER: controls the app sections:
			* todoController
			* userController
		+ MODEL: data:
			* todos
			* users
		+ VIEW: template files (EJS):
			* todo.ejs
			* account.ejs
	}
	- 'controllers/todoController.js': {
		module.exports = function(app) {
			app.get("/todo", function(req, res) {
			});
			
			app.post("/todo", function(req, res) {				
			});
			
			app.delete("/todo", function(req, res) {
			});
		};
	}
}
33.Making a To-do App (part 3): {
	- 'views/todo.ejs': {
		<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
		<link href="/assests/styles.css" rel="stylesheet" type="text/css"/>
		
		
		<h1>My Todo List</h1>
		<div id="todo-table">
			<form>
				<input type="text" name="item" placeholder="Add new item..." required/>
				<button type="submit">Add Item</button>
			</form>
			<ul>
				<li>Item 1</li>
				<li>Item 2</li>
				<li>Item 3</li>
			</ul>
		</div>
	}
	- 'controllers/todoController.js': {
		app.get("/todo", function(req, res) {
			res.render("todo");
		});
	}
	- 'public/assets/styles.css': {
		h1 {
			background: url(/assets/logo.png) no-repeat center;
		}
	}
}
34.Making a To-do App (part 4): {
	- 'controllers/todoController.js': {
		var bodyParser = require("body-parser");
		var urlencodedParser = bodyParser.urlencoded({extended: false});
		
		var data = [{item: 'get milk'}, {item: 'walk dog'}, {item: 'kick some coding ass'}];
		
		app.get("/todo", function(req, res) {
			res.render("todo", {todos: data});
		});
		
		app.post("/todo", urlencodedParser, function(req, res) {
			data.push(req.body);
			res.json(data);
		});
		
		app.delete("/todo/:item", function(req, res) {
			data = data.filter(function(todo) {
				return todo.item.replace(/ /g, '-') != req.params.item;
			});
			
			res.json(data);
		});
	}
	- 'views/todo.ejs': {
		+ Make sure you add a reference to the 'todo-list.js' file (in the 'assets' folder) 
		to the head of this file, for the AJAX requests to work :)
		<ul>
			<% for(var i = 0; i < todos.length; i++){ %>
				<li><%= todos[i].item %></li>
			<% } %>
		</ul>
	}
}