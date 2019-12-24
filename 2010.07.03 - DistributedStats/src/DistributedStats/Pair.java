package DistributedStats;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Simple container for a pair of objects, analogous to std::pair. This is
 * useful, for instance, if you want a map with a composite key. You could
 * use a nested map, or you could use a single map keyed by a Pair.
 */
public class Pair<A, B> implements Comparable<Pair<A, B>>
{
    /**
     * The individual pair members.
     */
    private A first_;
    private B second_;

    /**
     * Constructor
     */
    public Pair (final A a, final B b)
    {
        first_ = a;
        second_ = b;
    }

    /**
     * @return The first member of the pair.
     */
    public A first () { return first_; }

    /**
     * Sets the first member of the pair.
     */
    public void first (final A a) { first_ = a; }

    /**
     * @return The second member of the pair.
     */
    public B second () { return second_; }

    /**
     * Sets the second member of the pair.
     */
    public void second (final B b) { second_ = b; }

    @Override
    public boolean equals (Object o)
    {
        return o instanceof Pair && new EqualsBuilder()
            .append(this.first(), ((Pair)o).first())
            .append(this.second(), ((Pair)o).second())
            .isEquals();
    }

    @Override
    public int hashCode ()
    {
        return new HashCodeBuilder()
            .append(this.first())
            .append(this.second())
            .toHashCode();
    }

    public int compareTo (Pair<A,B> o)
    {
        return new CompareToBuilder()
            .append(this.first(), o.first())
            .append(this.second(), o.second())
            .toComparison();
    }

    public String toString ()
    {
        return new ToStringBuilder(this)
            .append("first", this.first())
            .append("second", this.second())
            .toString();
    }

    public static <A,B> Pair<A,B> makePair(final A first,
                                           final B second) {
        return new Pair<A,B>(first, second);
    }
}