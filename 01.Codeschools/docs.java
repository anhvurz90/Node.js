Node.Js Tutorial - Intro to Node.js
Real Time Web with Node.JS
https://www.youtube.com/watch?v=GJmFG4ffJZU&t=595s

1.What is Node.js {
	- Allows you to build scalable network applications using JavaScript on the server-side.
	- Node.js wraps V8(V8 is JavaScript Runtime (in Chrome browser) )
}
2.What could you build? {
	- Websocket Server(like a chat server)
	- Fast File Upload Client.
	- Ad Server
	- Any Real-Time Data Apps.
}
3.What is Node.js Not? {
	- A Web Framework
	- For Beginners (It is very low level).
	- Multi-threaded (You can think of it as a single threaded server)
}
4.Objective: Print File Contents {
	- Blocking Code: {
		+ Read file from Filesystem, set equal to "contents"
		+ Print contents
		+ Do something else
	}
	- Non-Blocking Code {
		+ Read file from Filesystem
			whenever you are complete, print the contents (This is a "Callback")
		+ Do Something else
	}
}
5.Blocking vs Non-Blocking {
	- Blocking Code: {
		var contents = fs.readFileSync("/etc/hosts");
		console.log(contents);
		console.log("Doing something else");
	}
	- Non-Blocking Code: {
		fs.readFile("/etc/hosts", function(err, contents) {
			console.log(contents);
		});
		console.log("Doing something else");
	} or {
		var callback = function(err, contents) {
			console.log(contents);
		}
		fs.readFile("/etc/hosts", callback);
	}
	
	- fs.readFile("/etc/hosts", callback);
	- fs.readFile("/etc/inetcfg", callback);
}
6.Node.js Hello Dog: {
	var http = require("http");//How we require modules
	
	http.createServer(function(req, res) {
		res.writeHeader(200);//Status code in header
		res.write("Hello, this is dog."); //Response body
		res.end(); //Close the connection
	}).listen(8080);//Listen for connections on this port
	
	console.log("Listening on port 8080...");
	
	-----------------------------------------------------
	
	$node hello.js // Run the server
		---> Listening on port 8080
	$curl http://localhost:8080 
		---> Hello, this is dog.
}
7.The Event loop: {
	- first time executing the code fragment above:Nodejs register events: request, connection, close..
	- then Nodejs starts the Event Loop when finished:
			Checking for events continuously
			When the event is coming, runs the Callback
}
8.Why Javascript? {
	Ryan Dahl: JavaScript has certain characteristics that make it very different than other dynamic languages, namely that it has no concept of threads. Its model of concurrency is completely based around events.
}
9.The Event Loop {
	Events processed 1 at a time
}
10.With long running Process: {
	var http = require("http");
	
	http.createServer(function(req, res) {
		res.writeHead(200);
		res.write("Dog is running.");
		setTimeout(function() {//represent long running process
			res.write("Dog is done!");
			res.end();
		}, 5000);//= 5 seconds
	}).listen(8080);
	
	----> 2 Callbacks here: request & timeout
}
11.Two callbacks timeline {
}
12.With Blocking timeline {
}
13.Typical blocking things: {
	- Calls out to web services
	- Reads/Writes on the Database
	- Calls to extensions
}











