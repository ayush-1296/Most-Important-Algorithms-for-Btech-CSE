/*
C++ program to "Find the path from root to the given nodes of a tree for multiple queries".

Given a tree with N vertices numbered from 0 to N – 1 (0th node is the root node). Also, given q queries containing nodes in the tree. The task is to find the path from the root node to the given node for multiple queries.
*/


#include <bits/stdc++.h> 
using namespace std; 

const int sz = 1e5; 

// Adjacency list representation of the tree 
vector<int> tree[sz]; 

// Boolean array to mark all the vertices which are visited 
bool vis[sz]; 

// Array of vector where ith index stores the path from the root node to the ith node 
vector<int> path[sz]; 

// Function to create an edge between two vertices 
void addEdge(int a, int b) 
{ 

	// Add a to b's list 
	tree[a].push_back(b); 

	// Add b to a's list 
	tree[a].push_back(a); 
} 

// Modified Breadth-First Function 
void bfs(int node) 
{ 

	// Create a queue of {child, parent} 
	queue<pair<int, int> > qu; 

	// Push root node in the front of the queue and mark as visited 
	qu.push({ node, -1 }); 
	vis[node] = true; 

	while (!qu.empty()) { 
		pair<int, int> p = qu.front(); 

		// Dequeue a vertex from queue 
		qu.pop(); 
		vis[p.first] = true; 

		// Get all adjacent vertices of the dequeued vertex s. If any adjacent has not been visited then enqueue it 

		for (int child : tree[p.first]) { 
			if (!vis[child]) { 
				qu.push({ child, p.first }); 

				// Path from root to this vertex is path from root to parent of this vertex followed by parent itself 
				path[child] = path[p.first]; 
				path[child].push_back(p.first); 
			} 
		} 
	} 
} 

// Function to print path from root to given node 
void displayPath(int node) 
{ 
	vector<int> ans = path[node]; 
	for (int k : ans) { 
		cout << k << " "; 
	} 
	cout << node << '\n'; 
} 

// Driver code 
int main() 
{ 

	// Number of vertices 
	int n = 6; 

	addEdge(0, 1); 
	addEdge(0, 2); 
	addEdge(1, 3); 
	addEdge(3, 4); 
	addEdge(3, 5); 

	// Calling modified bfs function 
	bfs(0); 

	// Display paths from root vertex to the given vertices 
	displayPath(2); 
	displayPath(4); 
	displayPath(5); 

	return 0; 
} 
