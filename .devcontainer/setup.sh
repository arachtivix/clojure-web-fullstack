#!/bin/bash

# Install Clojure CLI tools
curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh
chmod +x linux-install.sh
sudo ./linux-install.sh
rm linux-install.sh

# Install Leiningen
curl -O https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod +x lein
sudo mv lein /usr/local/bin/

# Install shadow-cljs
npm install -g shadow-cljs

echo "Clojure development environment ready!"