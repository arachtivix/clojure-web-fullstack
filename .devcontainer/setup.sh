#!/bin/bash

# Install Clojure CLI tools
curl -O https://download.clojure.org/install/linux-install-1.11.1.1429.sh
chmod +x linux-install-1.11.1.1429.sh
sudo ./linux-install-1.11.1.1429.sh
rm linux-install-1.11.1.1429.sh

# Install Leiningen
curl -O https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod +x lein
sudo mv lein /usr/local/bin/
lein version

# Install Babashka (fast Clojure scripting)
sudo bash < <(curl -s https://raw.githubusercontent.com/babashka/babashka/master/install)

# Install common web development tools
npm install -g shadow-cljs
npm install -g live-server

echo "Clojure development environment setup complete!"