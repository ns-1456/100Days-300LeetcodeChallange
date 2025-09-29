#!/usr/bin/env bash
set -euo pipefail

if [[ $# -lt 1 ]]; then
  echo "Usage: $0 DAY_NUMBER(001)" >&2
  exit 1
fi
DAY="$1"
DAY_DIR="problems/day_${DAY}"
mkdir -p "$DAY_DIR"

cat > "$DAY_DIR/README.md" <<EON
# Day ${DAY}

Problems: <id title>, <id title>, <id title>

- Notes follow template in docs/TEMPLATES.md
- Create subfolders per problem as you solve.
EON

echo "Created ${DAY_DIR}" 
