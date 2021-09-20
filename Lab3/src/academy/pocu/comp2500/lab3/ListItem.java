package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;

    private int subCount;
    private ArrayList<ListItem> subListItems;

    public ListItem(final String text) {
        this(text, '*');
    }

    public ListItem(final String text, final char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;

        this.subCount = 0;
        this.subListItems = new ArrayList<ListItem>();
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }

    public void setBulletStyle(final char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public ListItem getSublistItem(final int index) {
        return subListItems.get(index);
    }

    public void addSublistItem(final ListItem listItem) {
        listItem.setSubCount(this.subCount);
        subListItems.add(listItem);
    }

    public void removeSublistItem(final int index) {
        subListItems.remove(index);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();

        final String empty = "    ";
        for (int i = 0; i < this.subCount; ++i) {
            sb.append(empty);
        }
        sb.append(String.format("%c %s%s", bulletStyle, text, System.lineSeparator()));

        for (final ListItem listItem : subListItems) {
            sb.append(listItem.toString());
        }

        return sb.toString();
    }

    private void setSubCount(final int topSubCount) {
        this.subCount = topSubCount + 1;
        for (final ListItem l : this.subListItems) {
            l.setSubCount(this.subCount);
        }
    }
}
