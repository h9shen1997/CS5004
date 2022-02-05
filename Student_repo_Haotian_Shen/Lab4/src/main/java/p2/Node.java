package p2;

import java.util.Objects;

public class Node {
  private String value;
  private Node next;

  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node node = (Node) o;
    return getValue().equals(node.getValue()) && getNext().equals(node.getNext());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue(), getNext());
  }

  @Override
  public String toString() {
    return "Node{" +
        "value='" + value + '\'' +
        ", next=" + next +
        '}';
  }
}
