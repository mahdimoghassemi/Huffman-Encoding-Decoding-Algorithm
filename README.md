# Huffman Encoding and Decoding

## Table of Contents
- [Overview](#overview)
- [Huffman Encoding](#huffman-encoding)
- [Huffman Decoding](#huffman-decoding)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Encoding](#encoding)
  - [Decoding](#decoding)
---

## Overview

This repository contains Java code for Huffman encoding and decoding, along with supporting classes for working with Huffman codes. Huffman coding is a widely used algorithm for data compression that assigns variable-length codes to input characters based on their frequencies.

The project consists of the following Java classes:

- `Node`: Represents nodes used in the Huffman tree.
- `Code`: Represents a character and its corresponding Huffman code.
- `EncoderDecoder`: Provides encoding and decoding functionality.
- `Haffman`: Implements the Huffman encoding and decoding logic.

## Huffman Encoding

Huffman encoding is the process of converting a given input text into a compressed form using Huffman codes. The `Haffman` class provides methods to perform Huffman encoding. It constructs a Huffman tree, generates Huffman codes, and encodes the input text.

## Huffman Decoding

Huffman decoding is the process of converting a compressed text (encoded using Huffman codes) back to its original form. The `Haffman` class also includes methods for Huffman decoding. It reads encoded data, reconstructs the Huffman tree, and decodes the text.

## Getting Started

### Prerequisites

To run the Huffman encoding and decoding program, you need the following prerequisites:

- Java Development Kit (JDK) installed on your computer.
- A Java IDE or a text editor to edit and run the Java source code.

### Installation

1. Clone the repository to your local machine using the following command:

   ```bash
   git clone https://github.com/your-username/huffman-encoding.git
   ```

2. Open the project in your preferred Java IDE or text editor.

## Usage

### Encoding

To encode a text file, follow these steps:

1. Use the `Haffman.fromTextFile(filePath)` method to create a `Haffman` object from the text file.

2. Call the `encode()` method to generate the Huffman-encoded string.

3. Use the `writeEncodedToFile(outputFilePath)` method to save the encoded data to a file.

Example:

```java
Haffman huffman = Haffman.fromTextFile("input.txt");
String encodedText = huffman.encode();
huffman.writeEncodedToFile("encoded_output.txt");
```

### Decoding

To decode an encoded file, follow these steps:

1. Use the `Haffman.fromEncodedFile(filePath)` method to create a `Haffman` object from the encoded file.

2. Call the `decode()` method to recover the original text.

3. Use the `writeDecodedToFile(outputFilePath)` method to save the decoded text to a file.

Example:

```java
Haffman huffman = Haffman.fromEncodedFile("encoded_input.txt");
String decodedText = huffman.decode();
huffman.writeDecodedToFile("decoded_output.txt");
```

## Contributing

Feel free to submit issues, create pull requests, or suggest improvements. 

## Contact

For any questions or support, please contact mahdimoghassemi@gmail.com.

