# Streaming-Service: Binge Mode (Iterator Pattern)

## Problem Overview

We are simulating a small Netflix-like platform where a `Series` consists of multiple `Season` objects, and each season stores its `Episode`s differently (ArrayList, LinkedList, or lazily). Our goal is to provide a **uniform way to iterate** over episodes regardless of their internal storage or order.

## Goals

- Hide internal collections.
- Provide a common iteration interface: `hasNext()` / `next()`.
- Support multiple traversal orders: `normal`, `reverse`, `shuffle`.
- Allow iteration across multiple seasons in a binge-friendly way.

## Why Iterator Pattern?

Instead of exposing `List<Episode>`, we use the **Iterator Pattern** to:

- Hide internal data structures (e.g., you can change from ArrayList to TreeSet with no UI code impact).
- Support **multiple iteration strategies** (normal, reverse, shuffle).
- Provide **external iteration** via `for (Episode e : season)` using Java's `Iterable<Episode>`.
- Enable composition like `BingeIterator` across multiple seasons.

## Iterators Implemented

| Iterator              | Purpose                              |
|----------------------|--------------------------------------|
| `SeasonIterator`     | Iterates episodes in normal order    |
| `ReverseSeasonIterator` | Iterates episodes in reverse order |
| `ShuffleSeasonIterator` | Random order with fixed seed       |
| `BingeIterator`      | Iterates all episodes across seasons |

## Demo

The `Main.java` shows:

- All iteration modes per season.
- A full binge mode across seasons.

## Optional Enhancements

- `SkipIntroIterator` to start from N seconds in.
- `WatchHistoryFilter` to skip already-watched episodes.
- Performance testing for large episode sets (10k+).

