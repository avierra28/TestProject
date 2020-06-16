import string
import numpy as np  # numpy library for probability related functions
import re  # library for regular expressions

# build the productions dictionary
valid_chars = string.ascii_letters + '_'
productions = {
    '<prog>': (('int main()\n{\n<stat_list>\nreturn 0;\n}',), (1.0,)),
    '<stat_list>': (('<stat>', '<stat_list>\n<stat>',), (0.2, 0.8,)),
    '<stat>': ((
        '<cmpd_stat>',
        '<if_stat>',
        '<iter_stat>',
        '<assgn_stat>',
        '<decl_stat>',
        ), (0.05, 0.15, 0.15, 0.3, 0.35,)
    ),
    '<cmpd_stat>': (('{\n<stat_list>\n}',), (1.0,)),
    '<if_stat>': ((
        'if (<exp>)\n<stat>',
        'if (<exp>)\n<cmpd_stat>',
        'if (<exp>)\n<stat>\nelse\n<stat>',
        'if (<exp>)\n<cmpd_stat>\nelse\n<stat>',
        'if (<exp>)\n<stat>\nelse\n<cmpd_stat>',
        'if (<exp>)\n<cmpd_stat>\nelse\n<cmpd_stat>',
    ), (0.4, 0.05, 0.4, 0.05, 0.05, 0.05,)),
    '<iter_stat>': (
        ('while (<exp>)\n<stat>', 'while (<exp>)\n<cmpd_stat>',), (0.75, 0.25,)
    ),
    '<assgn_stat>': (('<id> = <exp>;',), (1.0, )),
    '<decl_stat>': (('<type> <id>;', '<type> <assgn_stat>', ), (0.4, 0.6,)),
    '<exp>': (('<exp> <op> <exp>', '<id>', '<const>'), (0.33, 0.33, 0.34,)),
    '<op>': ('+-*/', (0.3, 0.3, 0.2, 0.2,)),
    '<type>': (('int', 'double',), (0.6, 0.4,)),
    '<id>': (('<char><chardigit_seq>',), (1.0,)),
    '<const>': (('<digit>', '<digit><digit_seq>',), (0.2, 0.8,)),
    '<chardigit_seq>': (
        ('', '<char><chardigit_seq>', '<digit><chardigit_seq>'), (0.75, 0.25,)
    ),
    '<digit_seq>': (('', '<digit><digit_seq>'), (0.3, 0.7,)),
    '<char>': (
        valid_chars, tuple([
            1.0/len(valid_chars) for k in range(len(valid_chars))
        ])
    ),
    '<digit>': (string.digits, tuple([0.1 for k in range(10)])),
}

# function to make random selection of rhs given lhs
def select_rand_expansion(choices, probs):
    ix = np.searchsorted(np.cumsum(probs), np.random.random_sample())
    return choices[ix]

# main loop to generate random C program
program = '<prog>'
non_terminal_exists = True
while non_terminal_exists:
    match = re.search('<[^<]*>', program)
    if match is None:
        non_terminal_exists = False
    else:
        lhs = match.group()
        rhs_tuple = productions[lhs]
        rhs = select_rand_expansion(rhs_tuple[0], rhs_tuple[1])
        program = program[:match.start()] + rhs + program[match.end():]

print(program)
