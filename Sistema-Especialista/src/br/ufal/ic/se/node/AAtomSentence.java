/* This file was generated by SableCC (http://www.sablecc.org/). */

package br.ufal.ic.se.node;

import java.util.*;
import br.ufal.ic.se.analysis.*;

public class AAtomSentence extends PSentence
{
    private PAtomicsentence _atomicsentence_;

    public AAtomSentence()
    {
    }

    public AAtomSentence(
        PAtomicsentence _atomicsentence_)
    {
        setAtomicsentence(_atomicsentence_);

    }
    public Object clone()
    {
        return new AAtomSentence(
            (PAtomicsentence) cloneNode(_atomicsentence_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAtomSentence(this);
    }

    public PAtomicsentence getAtomicsentence()
    {
        return _atomicsentence_;
    }

    public void setAtomicsentence(PAtomicsentence node)
    {
        if(_atomicsentence_ != null)
        {
            _atomicsentence_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _atomicsentence_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_atomicsentence_);
    }

    void removeChild(Node child)
    {
        if(_atomicsentence_ == child)
        {
            _atomicsentence_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_atomicsentence_ == oldChild)
        {
            setAtomicsentence((PAtomicsentence) newChild);
            return;
        }

    }
}