package BlackJack.model.rules;

import BlackJack.model.RuleVisitor;

public interface IRule {
    void accept(RuleVisitor visitor);
}