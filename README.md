# Mindera Proximity Challenge

This project was developed in the scope of the Graduate Program of Mindera ([Workable](https://minderacraft.workable.com/j/85F6E6EF6F), [Facebook](https://www.facebook.com/minderasoftwarecraft/photos/a.327605690777422.1073741833.307653909439267/619592201578768/?type=3)).

## What it does

The objective was to create an algorithm that, provided an array of integers and a number of groups, it would group the integers into that amount of groups based on their proximity, as long as the total number of integers is greater or equal to the number of groups.

## How it does

A [k-means](https://en.wikipedia.org/wiki/K-means_clustering) strategy was taken. For the initialization, the first element of the provided array is chosen as the first center, and the remaining centers are selected from the array if they are the number with the highest distance from the nearest of the already selected centers.

## Examples

Check [examples](EXAMPLES.md).
