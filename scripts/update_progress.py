#!/usr/bin/env python3
import csv
from pathlib import Path

root = Path(__file__).resolve().parents[1]
tracker = root / 'trackers' / 'solved.csv'
readme = root / 'README.md'

def count_solved():
    if not tracker.exists():
        return 0
    with tracker.open() as f:
        r = csv.DictReader(f)
        return sum(1 for row in r if row.get('status','').lower() == 'done')

def update_readme(count: int):
    if not readme.exists():
        return
    text = readme.read_text()
    import re
    new_text = re.sub(r"(badge/solved-)(\d+)%2F300", lambda m: f"{m.group(1)}{count}%2F300", text)
    readme.write_text(new_text)

if __name__ == '__main__':
    solved = count_solved()
    update_readme(solved)
    print(f"Solved: {solved}/300")
