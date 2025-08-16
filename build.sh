#!/bin/bash
set -e

echo "Building production Clojure Web Fullstack Docker image..."
docker build -t clojure-web-fullstack .

echo "Production build complete! Run with:"
echo "docker run -p 3000:3000 clojure-web-fullstack"