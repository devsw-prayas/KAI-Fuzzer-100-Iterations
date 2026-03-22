# Kai — Sample Fuzzing Run (100 Iterations)

This repository contains a captured run of Kai, a structure-aware grey-box
Kotlin compiler fuzzer, over 100 iterations on a single thread against
kotlinc 2.3.

## The Arc

**Iteration 0** — the synthetic seed Kai always starts from:

```kotlin
class class_0 {
    fun fun_0(): Unit { var var_0: Int = 100 }
    operator fun minus(other: class_0): Int { return 0 }
}
typealias Alias_alias_0 = List<Map<String, Int>>
```

**Iteration 100** — what Kai grew from it, without any human guidance:

- `class_0` with 3 bounded type parameters and 9 member functions
- Every member function is `suspend inline` with multiple reified type params
- `holdsIn` contract declarations (`-Xallow-holdsin-contract`)
- Reified type parameters as catch clause exception types (`-Xallow-reified-type-in-catch`)
- Explicit backing fields with suspend type mismatches (`-Xexplicit-backing-fields`)
- DFA-based exhaustiveness checking through sealed hierarchies (`-Xdata-flow-based-exhaustiveness`)
- Two generic classes bounded by a sealed hierarchy with constructor params
- Contract extension functions with `returns() implies` and `returns(true) implies`
- Both destabilizer sentinel markers present — DB-4 and DB-5 fired on this program

**Everything compiles clean on K2 2.3. No program was authored. Every
construct emerged from the MCMC mutation chain crawling program space
incrementally from three lines of code.**

## What's in here

**`programs/`** — 100 generated Kotlin programs in chronological order,
named by timestamp. Scroll through them in order to watch the corpus evolve.

**`output.txt`** — Full console output from the run. Corpus growth,
mutation chain steps, destabilizer firing, compiler results, iteration rate.

## How it works

Kai starts from a minimal synthetic seed and applies depth-8 mutation chains.
Spatial Bidirectional Jitter (SBJ) distributes mutations across the entire
program tree using 2D centroid repulsion in (depth, siblingIndex) space —
preventing the clustering behaviour that makes most structure-aware fuzzers
degenerate into single-subsystem stress tests.

A parallel destabilizer pass fires on 30% of clean compiles, injecting
targeted stress constructs derived from open K2 YouTrack issues on top of
corpus programs. All K2 experimental flags are collected at startup and
passed globally — every program is compiled with the full experimental
surface active simultaneously.

## Running
 
Build:
 
```bash
./gradlew shadowJar
```
 
Run (Linux / macOS / Windows):
 
```bash
java -jar build/libs/kai-mvp-1.0-SNAPSHOT.jar -kotlinc "path/to/kotlinc" -log ./crashes -v
```