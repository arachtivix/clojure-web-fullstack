# Clojure Web Fullstack Application

A simple fullstack web application demonstrating Clojure backend with ClojureScript frontend, featuring EDN data exchange.

## Project Structure

```
clojure-web-fullstack/
├── project.clj                 # Leiningen project configuration
├── src/
│   └── web_app/
│       └── core.clj            # Backend server code
├── src-cljs/
│   └── web_app/
│       └── main.cljs           # ClojureScript frontend code
├── resources/
│   └── public/
│       ├── index.html          # Main HTML page
│       └── js/
│           └── main.js         # Compiled ClojureScript
└── README.md
```

## Features

- **Backend**: Clojure web server using Ring and Compojure
- **Frontend**: ClojureScript application compiled to JavaScript
- **Data Exchange**: EDN (Extensible Data Notation) format for API communication
- **Build System**: Leiningen with ClojureScript compilation

## Technology Stack

### Backend
- **Clojure 1.11.1**: Core language
- **Ring**: HTTP server abstraction
- **Compojure**: Routing library

### Frontend
- **ClojureScript 1.11.60**: Clojure compiled to JavaScript
- **EDN Reader**: For parsing EDN data from the backend

### Build Tools
- **Leiningen**: Project management and build tool
- **lein-cljsbuild**: ClojureScript compilation plugin

## API Endpoints

### `GET /`
Serves the main HTML page with the ClojureScript application.

### `GET /api/data`
Returns sample user data in EDN format:
```clojure
{:users [{:id 1 :name "Alice" :email "alice@example.com"}
         {:id 2 :name "Bob" :email "bob@example.com"}
         {:id 3 :name "Charlie" :email "charlie@example.com"}]
 :timestamp #inst "2024-01-01T12:00:00.000-00:00"}
```

## How It Works

### Backend (Clojure)
The backend server (`src/web_app/core.clj`) provides:
1. Static file serving for the HTML and compiled JavaScript
2. A REST API endpoint that returns EDN data
3. Proper content-type headers for EDN responses

### Frontend (ClojureScript)
The frontend (`src-cljs/web_app/main.cljs`) features:
1. **EDN Data Fetching**: Uses JavaScript's `fetch` API to get data from `/api/data`
2. **EDN Parsing**: Parses the EDN response using ClojureScript's built-in reader
3. **DOM Manipulation**: Updates the page content with the fetched data
4. **Event Handling**: Responds to button clicks to trigger data loading

### Data Flow
1. User clicks "Load Data from Backend" button
2. ClojureScript makes HTTP request to `/api/data`
3. Backend returns EDN-formatted data
4. ClojureScript parses EDN and extracts user information
5. DOM is updated to display the user list and timestamp

## Getting Started

### Prerequisites
- Java 8 or higher
- Leiningen 2.0 or higher

### Installation
1. Clone the repository
2. Install dependencies:
   ```bash
   lein deps
   ```

### Development

#### Compile ClojureScript
```bash
# One-time compilation
lein cljsbuild once dev

# Auto-compilation (watches for changes)
lein cljsbuild auto dev
```

#### Start the Server
```bash
lein run
```

The application will be available at `http://localhost:3000`

### Docker

#### Build and Run with Docker
```bash
# Build the Docker image
./build.sh

# Or manually:
docker build -t clojure-web-fullstack .
docker run -p 3000:3000 clojure-web-fullstack
```

### Production Build

For production, compile ClojureScript with advanced optimizations:
```bash
lein cljsbuild once prod
```

## Project Configuration

### project.clj
The main configuration includes:
- Clojure and ClojureScript dependencies
- ClojureScript build configurations for development and production
- Different optimization levels (`:none` for dev, `:advanced` for prod)

### ClojureScript Build Profiles
- **Development**: No optimizations, source maps enabled for debugging
- **Production**: Advanced optimizations for smaller file size

## Key Concepts Demonstrated

### EDN (Extensible Data Notation)
- Human-readable data format native to Clojure
- Supports rich data types (keywords, symbols, sets, etc.)
- Type-safe alternative to JSON
- Seamless integration between Clojure backend and ClojureScript frontend

### Isomorphic Data Structures
- Same data structures work on both client and server
- Keywords (`:users`, `:name`, `:email`) work identically in both environments
- No impedance mismatch between frontend and backend

### Functional Programming
- Immutable data structures
- Pure functions for data transformation
- Functional approach to DOM manipulation

## Extending the Application

### Adding New API Endpoints
1. Add routes in `src/web_app/core.clj`
2. Return EDN data using `pr-str` and appropriate content-type
3. Update ClojureScript to consume new endpoints

### Adding Frontend Features
1. Add functions to `src-cljs/web_app/main.cljs`
2. Recompile ClojureScript
3. Refresh the browser

### Database Integration
Consider adding:
- Database connection (e.g., PostgreSQL with next.jdbc)
- Data persistence layer
- More complex data models

## Troubleshooting

### ClojureScript Compilation Issues
- Ensure all parentheses are balanced
- Check for undefined variables or functions
- Verify namespace declarations

### Server Issues
- Check if port 3000 is available
- Verify all dependencies are installed
- Check server logs for error messages

### CORS Issues
If making requests from different origins, add CORS middleware to the Ring stack.

## License

This project is provided as an educational example and is free to use and modify.