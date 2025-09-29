#!/usr/bin/env python3
import csv
from pathlib import Path

root = Path(__file__).resolve().parents[1]
plan = root / 'trackers' / 'plan.csv'
problems_dir = root / 'problems'

def ensure_day(day: str, topic: str, problems: str):
    day_dir = problems_dir / f'day_{day}'
    day_dir.mkdir(parents=True, exist_ok=True)
    readme = day_dir / 'README.md'
    ids = problems.split('|') if problems else []
    content = [f"# Day {day}", "", f"Topic: {topic}", "", f"Problems: {', '.join(ids)}", "", "- Notes follow template in docs/TEMPLATES.md", "- Create subfolders per problem as you solve."]
    readme.write_text("\n".join(content))

if __name__ == '__main__':
    with plan.open() as f:
        r = csv.DictReader(f)
        for row in r:
            ensure_day(row['day'], row['topic'], row['problems'])
    print('Generated day READMEs from plan.csv')
