package p2;

public class StringList implements List {
  private Node headNode;
  private Integer size;

  public StringList(Node headNode, Integer size) {
    this.headNode = headNode;
    this.size = size;
  }

  public Node getHeadNode() {
    return headNode;
  }

  public Integer getSize() {
    return size;
  }


  @Override
  public Boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public Integer size() {
    return this.size;
  }

  @Override
  public Boolean contains(String element) {
    Node currentNode = this.headNode;
    while(currentNode.getNext() != null) {
      if(currentNode.getValue().equals(element)) {
        return true;
      } else {
        currentNode = currentNode.getNext();
      }
    }
    return false;
  }

  @Override
  public Boolean containsAll(List elements) {
    StringList helperList = (StringList)elements;
    Node helperNode = helperList.getHeadNode();
    while(helperNode.getNext() != null) {
      if(!this.contains(helperNode.getValue())) {
        return false;
      }
      helperNode = helperNode.getNext();
    }
    return true;
  }

  @Override
  public Boolean hasDuplicate() {
    Node currentNode = this.headNode;
    String value;
    Node helperNode;

    while(currentNode.getNext() != null) {
      value = currentNode.toString();
      helperNode = currentNode.getNext();

      while(helperNode.getNext() != null) {
        if(helperNode.getValue().equals(value)) {
          return true;
        } else {
          helperNode = helperNode.getNext();
        }
      }
      currentNode = currentNode.getNext();
    }
    return null;
  }

  @Override
  public List removeDuplicate() {
    return null;
  }
}
