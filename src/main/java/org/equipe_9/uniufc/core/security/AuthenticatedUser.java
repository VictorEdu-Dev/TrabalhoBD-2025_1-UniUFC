package org.equipe_9.uniufc.core.security;

import java.util.Set;

public record AuthenticatedUser(String username, Set<String> roles) {}