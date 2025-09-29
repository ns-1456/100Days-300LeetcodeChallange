#!/usr/bin/env python3
from pathlib import Path

root = Path(__file__).resolve().parents[1]
problems = root / 'problems'

missing = []
for day_dir in sorted(problems.glob('day_*')):
    if not (day_dir / 'README.md').exists():
        missing.append(str(day_dir / 'README.md'))

if missing:
    print("Missing required files:")
    for m in missing:
        print(" -", m)
    raise SystemExit(1)

print("Structure OK")
