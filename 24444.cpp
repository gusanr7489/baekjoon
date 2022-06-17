// 메모리 초과
#include <iostream>
#include <queue>
using namespace std;

void BFS(int vertex, int **graph, bool *visited, int* ans);

int main() {

    int N, K;
    int start;
    cin >> N >> K >> start;

    int *ans = new int[N+1];
    int **graph = new int*[N+1];
    bool *visited = new bool[N+1];

    for(int i=0; i<N+1; i++)
        graph[i] = new int[N+1];

    for(int i=0; i<K; i++) {
        int first, second;
        cin>> first >> second;
        graph[first][second] = 1;
        graph[second][first] = 1;
    }
    
    BFS(start, graph, visited, ans);

    for(int i=0; i<N+1; i++)
        delete[] graph[i];
    delete[] graph;
    delete[] ans;
    delete[] visited;

    for(int i=1; i<=K; i++) {
        cout << ans[i] << endl;
    }
    return 0;
}

void BFS(int vertex, int **graph, bool *visited, int *ans) {
    queue<int> q;

    q.push(vertex);
    visited[vertex] = true;
    int count = 0;

    while(!q.empty()) {
        int nodeIndex = q.front();
        q.pop();
        for(int i=1; i<sizeof(graph); i++) {
            if(!visited[i] && graph[nodeIndex][i]==1) {
                graph[i][nodeIndex] = 0;
                visited[i] = true;
                q.push(i);
            }

        }
        ans[nodeIndex] = ++count;
    }
}