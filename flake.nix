{
  description = "Watson's Blog - A Scala and Laika based blog";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
      in
      {
        devShells.default = pkgs.mkShell {
          buildInputs = with pkgs; [
            # Java development
            jdk21
            sbt
            
            # Node.js
            nodejs_20
            
            # Development tools
            git
          ];

          shellHook = ''
            echo "🚀 Welcome to Watson's Blog Development Environment"
            echo "Java version:"
            java -version
            echo "Node.js version:"
            node --version
            echo "sbt version:"
            sbt --version
          '';
        };
      }
    );
} 