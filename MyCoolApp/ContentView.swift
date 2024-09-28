//
//  ContentView.swift
//  MyCoolApp
//
//  Created by Anthony on 9/27/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
            
            
            // Add a button
            Button(action: {
                print("Button Pressed!")
            }) {
                Text("Press me!")
            }
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
